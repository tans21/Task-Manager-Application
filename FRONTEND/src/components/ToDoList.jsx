import React from 'react';
import tick from '../assets/tick.png';
import not_tick from '../assets/not_tick.png';
import delete_icon from '../assets/deletee.png';

const ToDoList = ({ text, id, isCompleted, dueDate, deleteTodo, toggle }) => {
  return (
    <div className='flex items-center my-3 gap-2'>

      {/* Task title and completion toggle */}
      <div onClick={() => toggle(id)} className='flex flex-1 items-center cursor-pointer'>
        <img src={isCompleted ? tick : not_tick} alt="" className='w-7' />
        <p className={`text-slate-700 ml-4 text-[17px] decoration-slate-500
          ${isCompleted ? "line-through" : ""}`}>
          {text}
        </p>
      </div>

      {/* Display due date */}
      <p className='text-sm text-gray-500 mr-4'>
        {new Date(dueDate).toLocaleDateString()}
      </p>

      {/* Delete button */}
      <img onClick={() => deleteTodo(id)} src={delete_icon} alt="" className='w-5 cursor-pointer' />
    </div>
  );
};

export default ToDoList;
