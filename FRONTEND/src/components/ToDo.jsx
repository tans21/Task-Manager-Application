import React, { useEffect, useRef, useState } from 'react'
import todo_icon from '../assets/todo_icon.png'
import ToDoList from './ToDoList'
const Todo = () => {

const [todoList, setTodoList] = useState([]);

const inputRef = useRef();

// Function that takes input 
const add = ()=> {
    const inputText = inputRef.current.value.trim();

    if(inputText === "") {
        return null;
    }
    const newTodo = {
        id: Date.now(),
        text: inputText,
        isCompleted: false,
    }
    setTodoList((prev)=> [...prev, newTodo]);
    inputRef.current.value = "";
}

// Function to delete tasks
const deleteTodo =(id)=> {
    setTodoList((prevTodos)=> {
        return prevTodos.filter((todo => todo.id !== id))
    })
}

// Function to update status of the tasks
const toggle = (id) => {
    setTodoList((prevTodos)=>{
        return prevTodos.map((todo)=>{
            if(todo.id === id){
                return {...todo, isCompleted: !todo.isCompleted}
            }
            return todo;
        })
    })
}

useEffect(()=> {
    console.log(todoList);
},[todoList])

  return (
    <div className='bg-white place-self-center w-11/12 max-w-md flex flex-col p-7 min-h-[550px] rounded-xl'>
{/* -----------Title----------- */}
    <div className='flex items-center mt-7 gap-2'>
        <img className='w-8' src={todo_icon} alt="" />
        <h1 className='text-3xl font-semibold'>To-Do List</h1>
    </div>
{/* -----------InputBox----------- */}

    <div className='flex items-center my-7 bg-gray-200 rounded-full'>
        <input ref={inputRef} className='bg-transparent border-0 outline-none flex-1 h-14 pl-6 pr-2 placeholder:text-slate-60'
        type='text' placeholder='Add your task'/>
        {/* ***************        ADD BUTTON    ********************* */}
        <button onClick={add} className='border-none rounded-full bg-orange-600 w-32 h-14 text-white text-lg font-medium cursor-pointer'>
            ADD +
        </button>
    </div>
{/* -----------ToDoList----------- */}

    <div>
        {todoList.map((item,index)=> {
            return <ToDoList key={index} text={item.text} id={item.id} isCompleted={item.isCompleted} deleteTodo={deleteTodo}
            toggle={toggle}/>
        })}
    </div>

    </div>
  )
}

export default Todo