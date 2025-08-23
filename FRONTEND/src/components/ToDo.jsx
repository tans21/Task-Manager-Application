import React, { useEffect, useRef, useState } from 'react';
import todo_icon from '../assets/todo_icon.png';
import ToDoList from './ToDoList';
import { getTasks, addTask, deleteTask, toggleTask } from '../api';

const Todo = () => {
  const [todoList, setTodoList] = useState([]);
  const inputRef = useRef();
  const dueDateRef = useRef();

  // Fetch tasks from backend
  const fetchTasks = async () => {
    try {
      const { data } = await getTasks();
      setTodoList(data);
    } catch (err) {
      console.error('Error fetching tasks:', err);
    }
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  // Add a task
  const add = async () => {
    const inputText = inputRef.current.value.trim();
    const dueDateValue = dueDateRef.current.value;

    if (!inputText) return;

    try {
      const { data } = await addTask({
        title: inputText,
        dueDate: dueDateValue ? new Date(dueDateValue) : new Date(),
        isCompleted: false,
      });

      setTodoList(prev => [...prev, data]);
      inputRef.current.value = '';
      dueDateRef.current.value = '';
    } catch (err) {
      console.error('Error adding task:', err);
    }
  };

  // Delete a task
  const handleDelete = async (id) => {
    try {
      await deleteTask(id);
      setTodoList(prev => prev.filter(task => task.id !== id));
    } catch (err) {
      console.error('Error deleting task:', err);
    }
  };

  // Toggle completion
  const handleToggle = async (id) => {
    try {
      const { data } = await toggleTask(id);
      setTodoList(prev => prev.map(task => (task.id === id ? data : task)));
    } catch (err) {
      console.error('Error toggling task:', err);
    }
  };

  return (
    <div className='bg-white place-self-center w-11/12 max-w-2xl flex flex-col p-7 min-h-[700px] rounded-xl'>
      {/* -----------Title----------- */}
      <div className='flex items-center mt-7 gap-2'>
        <img className='w-8' src={todo_icon} alt="" />
        <h1 className='text-3xl font-semibold'>To-Do List</h1>
      </div>

      {/* -----------InputBox----------- */}
      <div className='flex items-center my-7 gap-2'>
        <input
          ref={inputRef}
          className='bg-gray-200 border-0 outline-none flex-1 h-14 pl-6 pr-2 rounded-full placeholder:text-slate-60'
          type='text'
          placeholder='Add your task'
        />
        <input
          ref={dueDateRef}
          className='bg-gray-200 border-0 outline-none h-14 pl-4 pr-2 rounded-full'
          type='date'
        />
        <button
          onClick={add}
          className='border-none rounded-full bg-orange-600 w-28 h-14 text-white text-lg font-medium cursor-pointer'
        >
          ADD +
        </button>
      </div>

      {/* -----------ToDoList----------- */}
      <div>
        {todoList.map((item) => (
          <ToDoList
            key={item.id}
            text={item.title}
            id={item.id}
            isCompleted={item.isCompleted}
            dueDate={item.dueDate} 
            deleteTodo={handleDelete}
            toggle={handleToggle}
          />
        ))}
      </div>
    </div>
  );
};

export default Todo;
