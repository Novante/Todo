import React, {useEffect, useState} from "react";
import {dataApi} from "../Api";
import axios from "axios";

const RenderTodos = ({dataSource, id}) => {
    const [editMode, setEditMode] = useState(false)
    const [editTitle, setEditTitle] = useState(dataSource.todoName)
    const [editContent, setEditContent] = useState(dataSource.todoContent)

    const changeData = async () => {
        if (editTitle !== dataSource.todoName) {
            await axios.patch(`http://localhost:8080/api/todoitem/userId/1`, {
                todoId: id,
                todoName: editTitle
            })

        } if (editContent !== dataSource.todoContent){
            await axios.patch(`http://localhost:8080/api/todoitem/userId/1`, {
                todoId: id,
                todoContent: editContent
            })
        }
    }

    return (
        <tr style={styles.box}>
            {
                editMode === true ?
                   <td> <input type="text" onChange={e => setEditTitle(e.target.value)} style={styles.editMode} value={editTitle}></input></td>
                    :
                    <td style={{paddingLeft: '4px'}}>{editTitle}</td>
            }

            {
                editMode === true ?
                    <td><input type="text" onChange={e => setEditContent(e.target.value)} style={styles.editMode} value={editContent}></input></td>
                        :
                    <td style={{...styles.box, lineHeight: '50px', padding: 0, paddingLeft: '4px'}}>{editContent}</td>

            }

{
                editMode === false ?
                    <button onClick={() => setEditMode(!editMode)}
                            style={{width: '100%', height: '50px'}}>Edit
                    </button> :

                    <button onClick={() => {setEditMode(!editMode); changeData();}}
                            style={{width: '100%', height: '50px', backgroundColor: 'lightgray', border: '1px solid gray'}}>Confirm
                    </button>

            }

        </tr>
    )
}

export default RenderTodos;

const styles = {
    editMode: {
        height: '99%',
        width: '99%',
        lineHeight: '50px',
        padding: '10px'
    },
    box: {
        border: '1px solid #e6e6e6'
    },

}
