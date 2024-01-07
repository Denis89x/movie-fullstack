import axios from 'axios';

/*
export default axios.create({
    baseURL: 'https://c5c4-109-126-152-60.ngrok-free.app/',
    headers: {"ngrok-skip-browser-warning": "true"}
});*/

export default axios.create({

    baseURL: 'http://localhost:8080',
    headers: {"skip-browser-warning": "true"}

});
