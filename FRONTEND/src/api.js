import axios from 'axios';

const API = axios.create({
  baseURL: 'http://localhost:8080/api/todo',
});

export const getTasks = () => API.get('/');
export const addTask = (task) => API.post('/', task);
export const deleteTask = (id) => API.delete(`/${id}`);
export const toggleTask = (id) => API.put(`/${id}/toggle-complete`);
export const updateTask = (id, task) => API.put(`/${id}`, task);
