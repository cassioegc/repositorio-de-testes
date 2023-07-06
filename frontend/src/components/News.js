import { useEffect, useState } from "react";
import { New } from '../components/New';
import CardGroup from 'react-bootstrap/CardGroup';
import Badge from 'react-bootstrap/Badge';

export const News = ({ papel }) => {
    const [noticias, setNoticias] = useState([]);


    useEffect(() => {
        const data = new Date().toLocaleDateString('en-CA');
        fetch(`http://192.168.100.6:8080?papel=${papel}&data=${data}`, { headers: { 'cache-control': 'no-cache', } })
            .then(data =>
                data.json()
            )
            .then(data => {
                setNoticias(JSON.parse(data))
            });
    }, [papel]);

    return (
        noticias.length ? 
        (<div style={{margin: '0px 5px 5px 5px'}}>
            <h1 style={{textAlign: 'start' }}><Badge bg="secondary">{papel.toUpperCase()}</Badge></h1>

            <CardGroup >
                {noticias.map(({ NwsMsg: { id, headline } }) => <New key={id} title={headline} />)}
            </CardGroup>
        </div>) : null

    )
};