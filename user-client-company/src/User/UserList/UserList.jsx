import React, { useState, useEffect } from 'react'; 
import { getUsers } from './apiService';

const UserList = () => {

const [users, setUsers] = useState([]);

const [usernameFilter , setUsernameFilter] = useState('');

useEffect(() => {

const fetchUsers = async () => {

const data = await getUsers(usernameFilter); setUsers(data);

};

fetchUsers();

}, [usernameFilter]);

return (

<div>

<input type="text" placeholder="Filter by username" value={usernameFilter}onChange={(e) => setUsernameFilter(e.target.value)}/>

<ul>

{
users.map((user) => (

<li key={user.id}>Username: {user.username}, Email: {user.email} </li>
)
)
}
</ul>
</div>
);
};

export default UserList;