//构建本地图片路径
function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) {
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) {
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) {
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}