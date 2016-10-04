package com.softserverinc.edu.services;

import com.softserverinc.edu.entities.Issue;
import com.softserverinc.edu.entities.Project;
import com.softserverinc.edu.entities.ProjectRelease;
import com.softserverinc.edu.entities.User;
import com.softserverinc.edu.entities.enums.HistoryAction;
import com.softserverinc.edu.entities.enums.IssueStatus;
import com.softserverinc.edu.entities.enums.UserRole;
import com.softserverinc.edu.repositories.IssueRepository;
import com.softserverinc.edu.services.securityServices.BasicSecurityService;
import com.softserverinc.edu.services.securityServices.IssueSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private IssueService issueService;

    @Autowired
    private BasicSecurityService basicSecurityService;

    @Autowired
    private IssueSecurityService issueSecurityService;

    public Issue findById(Long id) {
        return issueRepository.findOne(id);
    }

    public List<IssueStatus> getAvaliableStatusesForStatus(IssueStatus status) {
        List<IssueStatus> result = new ArrayList<>();
        switch (status) {
            case OPEN:
                result.add(IssueStatus.IN_PROGRESS);
                result.add(IssueStatus.INVALID);
                return result;
            case IN_PROGRESS:
                result.add(IssueStatus.OPEN);
                result.add(IssueStatus.QA_VALIDATION);
                result.add(IssueStatus.INVALID);
                return result;
            case INVALID:
                result.add(IssueStatus.OPEN);
                return result;
            case QA_VALIDATION:
                result.add(IssueStatus.OPEN);
                result.add(IssueStatus.RESOLVED);
                return result;
            case RESOLVED:
                result.add(IssueStatus.OPEN);
                result.add(IssueStatus.INVALID);
                return result;
            default:
                return result;
        }
    }

    public Map<IssueStatus, String> getMapOfIssueStatuses(String selectedStatus) {
        Map<IssueStatus, String> result = new HashMap<>();
        for (IssueStatus status : getAvaliableStatusesForStatus(IssueStatus.valueOf(selectedStatus))) {
            result.put(status, status.toString());
        }
        return result;
    }

    public void saveIssueChanges(Issue issue) {
        User changedByUser = basicSecurityService.getActiveUser();
        if (issueService.isNewIssue(issue)) {
            issue.setCreatedBy(changedByUser);
        }
        historyService.writeToHistory(issue, changedByUser);
        save(issue);
    }

    public void saveIssueChangesFromAjax(Long issueId, String inputData, String action) {
        Issue issue = findById(issueId);
        HistoryAction historyAction = HistoryAction.valueOf(action);
        User changedByUser = basicSecurityService.getActiveUser();
        if (isIssueInputDataValid(issue, inputData, historyAction)) {
            historyService.writeToHistory(issue, changedByUser, inputData, historyAction);
            save(issue);
        }
    }

    public boolean isIssueInputDataValid(Issue issue, String inputData, HistoryAction action) {
        switch (action) {
            case CHANGE_ISSUE_ASSIGNEE:
                return isUserValidForIssue(issue, Long.valueOf(inputData));
            case CHANGE_ISSUE_STATUS:
                return isStatusValidForIssue(issue, IssueStatus.IN_PROGRESS.valueOf(inputData));
        }
        return false;
    }

    public boolean isNewIssue(Issue issue) {
        return (issue.getId() == null || issue.getId() == 0L);
    }

    public boolean isStatusValidForIssue(Issue issue, IssueStatus updatedStatus) {
        IssueStatus previousStatus = issue.getStatus();
        List<IssueStatus> avaliableStatuses = getAvaliableStatusesForStatus(previousStatus);
        for (IssueStatus status : avaliableStatuses) {
            if (updatedStatus.equals(status)) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public Page<Issue> findIssuesByRelease(ProjectRelease projectRelease, Pageable pageable) {
        return issueRepository.findByProjectRelease(projectRelease, pageable);
    }

    public boolean isUserValidForIssue(Issue issue, Long userId) {
        User updatedUser = userService.findOne(userId);
        List<User> avaliableUsers = userService.findUsersForRelease(issue.getProjectRelease());
        for (User user : avaliableUsers) {
            if (updatedUser.equals(user)) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public Page<Issue> findByReleaseAndIssueTitle(ProjectRelease projectRelease, String searchedString, Pageable pageable) {
        return issueRepository.findByProjectReleaseAndTitleContaining(projectRelease, searchedString, pageable);
    }

    @Transactional
    public Page<Issue> findIssuesByProject(Project project, String searchedString, Pageable pageable) {
        return issueRepository.findByProjectAndTitleContaining(project, searchedString, pageable);
    }

    public List<Issue> findAll() {
        return issueRepository.findAll();
    }

    @Transactional
    public Issue save(Issue issue) {
        return issueRepository.saveAndFlush(issue);
    }

    @Transactional
    public void delete(Long id) {
        issueRepository.delete(id);
    }

    @Transactional
    public Issue update(Issue issue) {
        return issueRepository.saveAndFlush(issue);
    }

    public Page<Issue> findByTitleContaining(String title, Pageable pageable) {
        return issueRepository.findByTitleContaining(title, pageable);
    }

    public Page<Issue> findAll(Pageable pageable) {
        return issueRepository.findAll(pageable);
    }

    @Transactional
    public Page<Issue> findByProject(Project project, Pageable pageable) {
        return issueRepository.findByProject(project, pageable);
    }

    public Page<Issue> findByUser(Principal principal, Pageable pageable) {
        return issueRepository.findByAssignee((userService.findByEmailIs(principal.getName())), pageable);
    }

    public List<User> checkAuthentication() {
        if (!issueSecurityService.isAuthenticated()) {
            return userService.findByRole(UserRole.ROLE_PROJECT_MANAGER);
        }
        return userService.findAll();
    }

}
