$(document).ready(function(){

    $('.table .eBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');

        var video = $(".myVideo #my-video").get(0);
        video.src = href;
        $('.myVideo h5').text(href);

        $('.myVideo #exampleModal').modal();
    });

    $('.table .delBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();
    })

});
