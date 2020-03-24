window.addEventListener('load', function() {
    //获取元素
    var imgs = this.document.querySelector('.imgs').querySelectorAll('img');
    var kuang =this.document.querySelector('.kuang');
    var on = this.document.querySelector('.on').querySelectorAll('img');
    //循环注册事件
    for(var i =0 ;i <imgs.length;i++){
        imgs[i].onclick = function(){
            kuang.src=this.src;
        }
    }
    for(var i =0 ;i < on.length;i++){
        on[i].onclick = function(){
            kuang.src=this.src;
        }
    }

        var hot = this.document.querySelector('.hot').querySelectorAll('a');  //详情
        var msgImgs = this.document.querySelector('.msgImgs');     //商品
        var eva = this.document.querySelector('.eva');     //评论
        //for循环绑定事件
        for ( var i = 0; i< hot.length; i++){
            //开始给li是指索引号
            hot[i].setAttribute('index',i);
            hot[i].onclick = function(){
                for(var i = 0 ;i < hot.length; i++){
                hot[i].className = '';
                }
                this.className = 'current';
                //显示下面的内容
                //使用排他思想
                var index = this.getAttribute('index');
                console.log(index);
                
                if( index == 0){
                    msgImgs.style.display = 'block';
                    eva.style.display = 'none';
                }
                if(index ==1){
                    msgImgs.style.display = 'none';
                    eva.style.display = 'block';
                }
            }    
        //设置自定义属性来区分每一个li，通过getattribute的到其属性
        }
})