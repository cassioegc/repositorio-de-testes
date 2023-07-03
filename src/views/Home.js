import React from 'react';
import { News } from '../components/News';

export const Home = () => {
    const papeis = ['bcff', 'mxrf'];

    return (
        <div>
            
        {papeis.map(papel => <News papel={papel} key={papel}/>) }
        </div>
    );
};