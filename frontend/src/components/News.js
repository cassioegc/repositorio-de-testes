import { useEffect, useState } from "react";
import { New } from '../components/New';
import CardGroup from 'react-bootstrap/CardGroup';
import Badge from 'react-bootstrap/Badge';

export const News = ({ papel, data }) => {
    const [noticias, setNoticias] = useState([]);

    useEffect(() => {
        fetch(`http://localhost:8080?papel=${papel}&data=${data}`, { headers: { 'cache-control': 'no-cache', } })
            .then(data =>
                data.json()
            )
            .then(data => {
                setNoticias(data)
            });
    }, [papel, data]);

    return (
        noticias?.length ? 
        (<div style={{margin: '0px 5px 5px 5px'}}>
            <h1 style={{textAlign: 'start' }}><Badge bg="secondary">{papel.toUpperCase()}</Badge></h1>
            <CardGroup style={{ display:'flex', flexWrap:'wrap', flexDirection:'row' }}>
                {noticias.map(({ NwsMsg: { id, headline , dateTime} }) => <New key={id} title={headline} date={dateTime}/>)}
            </CardGroup>
        </div>) : null
    )
};