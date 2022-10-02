import {useContext, useEffect, useRef, useState} from "react";
import React from "react";
import {dataApi} from "../Api";
import axios from "axios";
import RenderTodos from "../components/RenderTodos";

const Homepage = () => {

    const [dataSource, setDataSource] = useState([])

    useEffect(() => {
        fetchTodos()
    }, [])

    useEffect(() => {
    }, [dataSource])

    const fetchTodos = async () => {
        const data = await axios.get('http://localhost:8080/api/todoitem/listId/1/userId/1')
        setDataSource(data.data)
    }

    const handleNewTodoPress = async () => {
        setDataSource([...dataSource, {todoName: 'Todo-titel', todoContent: 'Todo-beskrivning'}])
        await axios.post('http://localhost:8080/api/todoitem/listId/1/userId/1', {todoName: 'Todo-titel', todoContent: 'Todo-beskrivning'})
    }

    return (
        <div style={{display: 'flex', justifyContent: 'center'}}>
            <div style={{display: 'flex', justifyContent: "center", textAlign: 'left', flexDirection: 'column', alignItems: 'center', width: '50%', border: '1px solid'}}>
                <table style={{...styles.box, width: '100%'}}>
                    <tr style={{height: 50, ...styles.box, backgroundColor: '#f7f7f7'}}>
                        <th style={{...styles.box, width: '20%', paddingLeft: '4px'}}>Titel</th>
                        <th style={{...styles.box, width: '70%', paddingLeft: '4px'}}>Beskrivning</th>
                        <th style={{...styles.box, width: '10%', textAlign: 'center'}}>Edit</th>
                    </tr>
                    {dataSource.map((dataSource, index) => {
                        return (
                           <RenderTodos id={dataSource.todoId} key={dataSource.todoId} dataSource={dataSource} setDataSource={setDataSource}/>
                        )
                    })}
                </table>
                <button onClick={handleNewTodoPress} style={{marginRight: 'auto', marginTop: 5}}>
                    Ny todo
                </button>

            </div>
        </div>

    )

}

const styles = {
    box: {
        border: '1px solid #e6e6e6'
    },


}

export default Homepage;
