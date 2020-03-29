$(document).ready(function () {

    ////////////////
    //VARIABLES
    ////////////////
    var view = $(window),
        html = $('html'),
        body = $('body');

    ////////////////
    //SKILLS ANIMATION
    ////////////////
    $('ul#skills').addClass("ready");
    $('ul#skills li').each(function () {
        var i = $(this).index();
        $(this).delay(100 * i).animate({right: "0%"}, 1000, function () {
            $(this).children('span').fadeIn(600);
        });
    });

    ////////////////
    //PRETTYPHOTO
    ////////////////
    $('a[data-rel]').each(function () {
        $(this).attr('rel', $(this).data('rel'));
    });
    $("a[rel^='prettyPhoto']").prettyPhoto({
        overlay_gallery: false,
        social_tools: '',
        deeplinking: false,
        default_width: 500,
        opacity: "1"
    });


    ////////////////
    //FORM STUFF...
    ////////////////
    $("#contactform #submit_btn").click(function () {

        $("#contactform .input, #contactform textarea").removeClass('error');

        var name = $("#contactform input#name");
        if (name.val() == "") {
            name.addClass('error').focus();
            return false;
        }
        var email = $("#contactform input#email");
        if (email.val() == "") {
            email.addClass('error').focus();
            return false;
        }
        var message = $("#contactform textarea#message");
        if (message.val() == "") {
            message.addClass('error').focus();
            return false;
        }
    });

    ////////////////
    //SUCCESSFUL MESSAGE ALERT
    ////////////////
    if (window.location.hash == "#return") {
        $('#contactform').slideUp(800, function () {
            $('#messageSent').fadeIn(800);
        });
    }

    ////////////////
    //CLONE NAME AND SOCIAL BUTTONS
    ////////////////
    $('#titleName, #socialIcons').clone().appendTo('#sticker');

    ////////////////
    //RESPONSIVE CHECK
    ///////////////
    function responsive() {
        if (view.width() < 820) {
            body.addClass('respond');
        } else {
            body.removeClass('respond');
        }
    }

    responsive();

    ////////////////
    //WINDOW SCROLL
    ////////////////
    view.scroll(function () {
        //SHOW/HIDE TOP PANEL
        if (view.scrollTop() > 140) {
            $('#sticker').stop().animate({top: "0"}, 500);
        } else {
            $('#sticker').stop().animate({top: "-60px"}, 500);
        }

        //PARALLAX BACKGROUND STUFF
        var scrollPosition = $(window).scrollTop() * .25;
        body.css({backgroundPosition: '0px -' + scrollPosition + 'px'});
    });

    ////////////////
    //WINDOW RESIZE
    ///////////////
    view.resize(function () {
        responsive();
    });

    ////////////////
    //WINDOW LOAD
    ////////////////
    view.load(function () {
        responsive();
    });

});