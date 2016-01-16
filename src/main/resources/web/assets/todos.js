
var todosListEl = document.querySelector("#js-todos-list");
var inputTodoEl = document.querySelector("#js-input-todo");

//-----------------------------------------

var lisTodos = "";

var liTodo = function(todo){
    var className = todo.done?"done":"";
    return "<li class="+className+">"+todo.name+"</li>";
}

//-----------------------------------------

var getTodos = new XMLHttpRequest();
getTodos.open("GET", "http://localhost:8000/todos", true);

getTodos.addEventListener("load", function(){
    var todos = JSON.parse(this.response);    
    todos.map(function(todo){
        lisTodos = lisTodos.concat(liTodo(todo));  
    });
    todosListEl.innerHTML = lisTodos;
});

getTodos.send();

//-----------------------------------------

var postTodos = new XMLHttpRequest();
postTodos.open("POST", "http://localhost:8000/todos", true);
postTodos.setRequestHeader("Content-type", "application/json");

postTodos.addEventListener("load", function(){
    var newTodo = JSON.parse(this.response);    
    lisTodos = lisTodos.concat(liTodo(newTodo));
    todosListEl.innerHTML = lisTodos;
});

//-----------------------------------------

inputTodoEl.addEventListener("keypress", function(e){
    if( e.keyCode == 13 ){
        postTodos.send(JSON.stringify({ name: inputTodoEl.value, done : false }));
        this.value = "";
    }
});

