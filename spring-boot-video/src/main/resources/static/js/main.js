/**
 *
 */
(function() {
  var video = document.querySelector('video');
  var canvas = document.querySelector('canvas');
  var img = document.querySelector('img');

  var constraints = {
    video:true,
    audio:false
  };

  navigator
    .mediaDevices
    .getUserMedia(constraints)
    .then(function(stream){
      video.srcObject=stream;
      video.play();
    }).catch(function(err){
    });
})();
