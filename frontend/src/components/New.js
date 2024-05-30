import React, { useEffect, useState } from 'react';
import Card from 'react-bootstrap/Card';

export const New = ({ title, date }) => {
    const [formattedDate, setFormattedDate] = useState('');

    useEffect(() => {
        const dateJS = new Date(date);
        setFormattedDate(dateJS.toLocaleString())
    }, [date]);

    return (
        <Card style={{ maxWidth: '18rem', class: 'col-sm', flex: '1 200px' }}>
            <Card.Body>
                <Card.Title>{title}</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">{formattedDate}</Card.Subtitle>

            </Card.Body>
        </Card>
    );
};