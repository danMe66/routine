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
      var formdata = new FormData();
      if (files.length !== undefined) {
        // todo 这个判断条件需要优化
        for (let k = 0; k < files.length; k++) {
          formdata.append(
            "file[]",
            // 处理文件(处理为多文件上传)
            files[k].file
          );
        }
      } else {
        formdata.append(
          "file[]",
          // 处理文件(处理为单文件上传)
          files.file
        );
      }
      this.$axios({
        url: 'http://bbs-api.test/api/upload',
        method: "post",
        data: formdata,
        headers: {
          "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"
        }
      }).then(res => {
        if (res.data.code == 200) {
          var obj = res.data.data;
          for (var i in obj) {
            this.photoArr += obj[i] + ",";
          }
        }
        console.log(res.data.code);
      });
    }
  }
};
</script>