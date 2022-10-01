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

    const fetchTodos = async () => {
        const data = await axios.get('http://localhost:8080/api/todoitem/listId/1/userId/1')
        setDataSource(data.data)
    }

    return (
        <div>
            <div style={{display: 'flex', justifyContent: "center", textAlign: 'left'}}>
                <table style={{width: '50%', ...styles.box}}>
                    <tr style={styles.box}>
                        <th style={styles.box}>Titel</th>
                        <th style={styles.box}>Beskrivning</th>
                    </tr>
                    {dataSource.map((dataSource) => {
                        return (
                            <tr>
                                <td style={styles.box}>{dataSource.todoName}</td>
                                <td style={styles.box}>{dataSource.todoContent}</td>
                            </tr>
                        )
                    })}

                </table>
            </div>
        </div>
    )

}

const styles = {
    box: {
        border: '1px solid black'
    }
}

export default Homepage;
