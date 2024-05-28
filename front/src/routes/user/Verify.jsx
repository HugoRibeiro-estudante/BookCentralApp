export async function Verify(email) {
    const response = await fetch(`http://localhost:8080/api/v1/user/email/${email}`);
    const data = await response.json();

    if (data == null) {
        return false;
    }

    // Save user data in local storage
    localStorage.setItem('userData', JSON.stringify({
    id: data.id,
    name: data.name,
    userName: data.userName,
    email: data.email,
    age: data.age
    }));
    
    return true;
}


