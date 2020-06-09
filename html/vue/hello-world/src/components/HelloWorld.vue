<template>
  <div>
    <h3>文件上传</h3>
    <van-uploader :after-read="fileup" v-model="fileList" multiple :max-count="2" />
  </div>
</template>
<script>
export default {
  name: "uploaderfile",
  data() {
    return {
      fileList: []
    };
  },
  methods: {
    fileup(files) {
      console.log(files);
      this.$axios.defaults.headers["Content-Type"] =
        "application/x-www-form-urlencoded;charset=UTF-8";
      this.$axios.defaults.headers["Authorization"] =
        "Bearer 28390af2-768c-43de-9338-4f7537fb7741";
      var ldd = [];
      for (let i = 0; i < files.length; i++) {
        console.log(files[i]);
        ldd.push = this.base64ToFile(files[i], files[i].file.name);
      }
      console.log('-------');
      console.log(ldd);
      var formdata = new FormData();
      formdata.append('file',ldd);
      // 上传文件到API
      this.$axios
        .post("http://bbs-api.test/api/upload", formdata)
        .then(function(res) {
          return res;
        });
    },
    base64ToFile(urlData, fileName) {
        let arr = urlData.split(',');
        let mime = arr[0].match(/:(.*?);/)[1];
        let bytes = atob(arr[1]); // 解码base64
        let n = bytes.length
        let ia = new Uint8Array(n);
        while (n--) {
            ia[n] = bytes.charCodeAt(n);
        }
        return new File([ia], fileName, { type: mime });
    },
  }
};
</script>