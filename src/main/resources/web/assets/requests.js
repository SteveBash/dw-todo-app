
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

var deleteTodos = function(id){
    var req = new XMLHttpRequest();
    req.open("DELETE", "http://localhost:8000/todos/" + id, true);
    //req.addEventListener("load", function(){
        //getTodos.send();
    //});
    return req;
}

//-----------------------------------------

var updateTodos = function(id){
    var req = new XMLHttpRequest();
    req.open("PUT", "http://localhost:8000/todos/" + id, true);
    //req.addEventListener("load", function(){
        //getTodos.send();
    //});
    return req;
}

//-----------------------------------------
