<template>
  <div>
    <h3>文件上传</h3>
  <van-uploader :after-read="fileup"/>
  </div>
</template>
<script>
export default {
  name: 'uploaderfile',
  data () {
    return {
      fileList: [],
    }
  },
  methods: {
    fileup(file) {
      this.$axios.defaults.headers["Content-Type"] =
          "application/x-www-form-urlencoded;charset=UTF-8";
        var formdata = new FormData();
        formdata.append(
          "file",
          // 处理文件
          this.dataURLtoFile(file.content, this.fileName)
        );
        // 上传文件到API
        this.$axios
          .post("https://www.baidu.com", formdata)
          .then(function(res) {
            return res;
          });
    },
    dataURLtoFile(dataurl, filename) {
      //将base64转换为文件
      var arr = dataurl.split(","),
        mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]),
        n = bstr.length,
        u8arr = new Uint8Array(n);
      while (n--) {
        u8arr[n] = bstr.charCodeAt(n);
      }
      return new File([u8arr], filename, { type: mime });
    },
  }
}
</script>