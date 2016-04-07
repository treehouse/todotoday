$(function(){
    $('.todo-item label').click(function(){
        $(this).parent('form').submit();
    });
});