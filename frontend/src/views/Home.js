import React from 'react';
import { News } from '../components/News';

export const Home = () => {
    const papeis = ['xpml', 'visc','bcff', 'mxrf', 'irdm', 'hglg', 'xplg', 'alup', 'itsa', 'taee', 'pssa', 'klbn', 'vbbr'];

    return (
        <div>
            {papeis.map(papel => <News papel={papel} key={papel}/>) }
        </div>
    );
};