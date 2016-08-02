/**
 * Created by ihorlt on 02.08.16.
 */


$(document).ready(function () {

    //form login validation
    $('#loginform').validate({ // initialize the plugin
        invalidHandler: function(event, validator) {
            $("#loginform div.input-group").addClass("has-error");
        },
        rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 6
            }
        }
    });

});