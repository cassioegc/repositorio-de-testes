import React from 'react';
import Card from 'react-bootstrap/Card';

export default New = ({ title, text, link }) => {

    return (
        <Card style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title>{{title}}</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">Card Subtitle</Card.Subtitle>
                <Card.Text>
                    {{ text }}
                </Card.Text>
                <Card.Link href="#">{{ link }}</Card.Link>
            </Card.Body>
        </Card>
    );
};