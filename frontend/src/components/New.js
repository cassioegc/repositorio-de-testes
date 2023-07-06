import React from 'react';
import Card from 'react-bootstrap/Card';

export const New = ({ title, text }) => {

    return (
        <Card style={{ maxWidth: '18rem' }}>
            <Card.Body>
                <Card.Title>{title}</Card.Title>
            </Card.Body>
        </Card>
    );
};