import React, { useEffect, useState } from 'react';
import Card from 'react-bootstrap/Card';

export const New = ({ id, title, date }) => {
    const [formattedDate, setFormattedDate] = useState('');

    useEffect(() => {
        const dateJS = new Date(date);
        setFormattedDate(dateJS.toLocaleString())
    }, [date]);

    const onClickOpenNewTab = () => {
        const url = `https://sistemasweb.b3.com.br/PlantaoNoticias/Noticias/Detail?idNoticia=${id}&agencia=18&dataNoticia=${date}`
        window.open(url, '_blank').focus();
    };

    return (
        <Card style={{ maxWidth: '18rem', class: 'col-sm', flex: '1 200px', cursor: 'pointer' }} onClick={onClickOpenNewTab}>
            <Card.Body>
                <Card.Title>{title}</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">{formattedDate}</Card.Subtitle>
            </Card.Body>
        </Card>
    );
};