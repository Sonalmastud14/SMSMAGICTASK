const API_URL = 'http://localhost:8080/UserClientCompany/api';

export const getUsers = async (usernameFilter) => {

let url = `${API_URL}/users`;

if (usernameFilter) { url += `?username=${usernameFilter}'`;

}

const response = await fetch(url);

return await response.json();
};