/**
 * Created by baidu on 18/4/2.
 */
//var wsUrl = "ws://127.0.0.1:8812";
var wsUrl = "ws://127.0.0.1:8812";

var websocket = new WebSocket(wsUrl);

//实例对象的onopen属性
websocket.onopen = function(evt) {
    console.log("conected-swoole-success");
}

// 实例化 onmessage
websocket.onmessage = function(evt) {
    // evt.data
    push(evt.data);
    // todo
    console.log("ws-server-return-data:" + evt.data);
}

//onclose
websocket.onclose = function(evt) {
    console.log("close");
}
//onerror

websocket.onerror = function(evt, e) {
    console.log("error:" + evt.data);
}

function push(data) {
   data = JSON.parse(data);
   html = '<div class="comment">';
   html += '<span>'+data.user+'</span>';
   html += '<span>'+data.content+'</span>';
   html += '</div>';
   $('#comments').append(html);
}