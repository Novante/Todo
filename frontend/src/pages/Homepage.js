import {Button, Form, Popconfirm, Table} from "antd";
import {useContext, useEffect, useRef, useState} from "react";
import React from "react";
import Input from "antd/es/input/Input";
import {dataApi} from "../Api";
import axios from "axios";

const Homepage = () => {

    const [dataSource, setDataSource] = useState([])

    useEffect(() => {
        fetchTodos()
    }, [])

    useEffect(() => {
        console.log('farsatacklare', dataSource)
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
                        <th style={{...styles.box, width: '20%'}}>Titel</th>
                        <th style={{...styles.box, width: '80%'}}>Beskrivning</th>
                    </tr>
                    {dataSource.map((dataSource) => {
                        return (
                            <tr key={dataSource.todoId} style={{height: 50}}>
                                <td style={styles.box}>{dataSource.todoName}</td>
                                <td style={styles.box}>{dataSource.todoContent}</td>
                            </tr>
                        )
                    })}
                </table>
                <Button onClick={handleNewTodoPress} style={{marginRight: 'auto', marginTop: 5}}>
                    Ny todo
                </Button>
            </div>
        </div>

    )

}

const styles = {
    box: {
        border: '1px solid #e6e6e6'
    }
}

export default Homepage;
