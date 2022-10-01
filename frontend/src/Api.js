import axios from 'axios';

let API_BASE_URL = 'http://localhost:8080/api/';

const service = axios.create({
    baseURL: API_BASE_URL,
    responseType: 'json',
    timeout: 30000,
});

class DataAPI {
    constructor() {
        this.instance = service;
    }


    getTechniqueAll() {
        return this.instance.get('technique/all');
    }

    getAllTodoListItemsByListIdAndUserId(listId, userId){
        return this.instance.get(`todoitem/listId/1/userId/1`)
    }



}
const dataApi = new DataAPI();

export {dataApi};
