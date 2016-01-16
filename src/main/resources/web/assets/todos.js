
var todosListEl = document.querySelector("#js-todos-list");
var inputTodoEl = document.querySelector("#js-input-todo");

//-----------------------------------------

var lisTodos = "";

var liTodo = function(todo){
    var className = todo.done?"done":"";
    return "<li data-todo-id="+ todo.id +" class="+className+">"+todo.name+ deleteButton(todo) +"</li>";
}

var deleteButton = function(todo){
   return "<button data-todo-id="+todo.id+">x</button>"; 
}

todosListEl.addEventListener("click", function(e){
    var id = e.target.attributes["data-todo-id"].value;
    if(e.target.tagName.toUpperCase()=="BUTTON")
        deleteTodos(id).send();
    else{
        updateTodos(id).send(JSON.stringify({ done : "true"}));
    }
});

inputTodoEl.addEventListener("keypress", function(e){
    if( e.keyCode == 13 ){
        postTodos.send(JSON.stringify({ name: inputTodoEl.value, done : false }));
        this.value = "";
    }
});

getTodos.send();
