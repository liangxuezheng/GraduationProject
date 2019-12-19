$('.add-btn').on('click',function(){
	$('#insert').show();
})
$('.quxiao').on('click',function(){
	$('#insert').hide();
})
$('.submit').on('click',function(){
	$('#insert').hide();
})
$('.tab-shenhe').on('click',function(){
  $('.tab-shenhe').css('background-color','rgba(22, 155, 213, 1)')
  .siblings().css('background-color','rgba(255, 255, 255, 1)');
  $('.shenhe').show();
  $('.tongguo').hide();
  $('.jingxuan').hide();
  $('.nogo').hide();
})
$('.tab-tongguo').on('click',function(){
  $('.tab-tongguo').css('background-color','rgba(22, 155, 213, 1)')
  .siblings().css('background-color','rgba(255, 255, 255, 1)');
  $('.shenhe').hide();
  $('.jingxuan').hide();
  $('.nogo').hide();
  $('.tongguo').show();
})
$('.tab-jingxuan').on('click',function(){
  $('.tab-jingxuan').css('background-color','rgba(22, 155, 213, 1)')
  .siblings().css('background-color','rgba(255, 255, 255, 1)');
  $('.shenhe').hide();
  $('.jingxuan').show();
  $('.nogo').hide();
  $('.tongguo').hide();
})
$('.tab-nogo').on('click',function(){
  $('.tab-nogo').css('background-color','rgba(22, 155, 213, 1)')
  .siblings().css('background-color','rgba(255, 255, 255, 1)');
  $('.shenhe').hide();
  $('.jingxuan').hide();
  $('.nogo').show();
  $('.tongguo').hide();
})


$('.back').on('click',function(){
  $('#back').show();
})
$('.zhen-no').on('click',function(){
  $('.zhen-opcity').hide();
})
$('.malk').on('click',function(){
  $('.zhen-opcity').show();
})

$('.star-no').on('click',function(){
  $('#Star').hide();
})

$('.Star').on('click',function(){
  $('#Star').show();
})


$('.newly').on('click',function(){
  $('#newly').show();
})
$('.newly-no').on('click',function(){
  $('#newly').hide();
})
$('.module').on('click',function(){
  window.location.href = "module.html";
})
$('.module-no').on('click',function(){
  $('.opctiy').hide();
})

$('.new-btn').on('click',function(){
  $('.opctiy').show();
})
$('.bianji').on('click',function(){
  $('.opctiy2').show();
})
$('.opctiy2-no').on('click',function(){
  $('.opctiy2').hide();
})
//文件上传
$("input[type='file']").change(function(){ 
	
 		var file = this.files[0];
   		if (window.FileReader) {    
            var reader = new FileReader();    
            reader.readAsDataURL(file);    
            //监听文件读取结束后事件    
          reader.onloadend = function (e) {
          	
            $(".img").attr("src",e.target.result);
			   //e.target.result就是最后的路径地址
            };  
             
       } 
	});