<html>
<head>
    <link href="/ktnb_web/uploadify/uploadify.css" rel="stylesheet" />
</head>
<body>
<div id="main">
<p><input type="file" id="multipleFiles" /></p>
<p><button id="btn1">Upload Files</button></p>
</div>
<script src="/ktnb_web/uploadify/jquery-1.4.2.min.js"></script>
<script src="/ktnb_web/uploadify/swfobject.js"></script>
<script src="/ktnb_web/uploadify/jquery.uploadify.v2.1.4.min.js"></script>
<script type="text/javascript">
  $("#multipleFiles").uploadify({
      'uploader': '/ktnb_web/uploadify/uploadify.swf',
      'script': 'multiUpload.do',
      'fileDataName': 'file',
      'buttonText': 'File Input...',
      'multi': true,
      'sizeLimit': 30485760,
      'simUploadLimit': 5,
      'cancelImg': '/ktnb_web/uploadify/cancel.png',
      'auto': false,
      'onError': function (a, b, c, d) {
          if (d.status == 404)
              alert("Could not find upload script. Use a path relative to: " + "<?= getcwd() ?>");
          else if (d.type === "HTTP")
              alert("error " + d.type + ": " + d.status);
          else if (d.type === "File Size")
              alert(c.name + " " + d.type + " Limit: " + Math.round(d.info / (1024 * 1024)) + "MB");
          else
              alert("error " + d.type + ": " + d.text);
      }
  });
  $("#btn1").click(function () {
      $('#multipleFiles').uploadifyUpload();
  });
</script>
</body>
</html>