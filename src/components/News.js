import { useEffect, useState } from "react";

export const News = ({ papel }) => {
    const [noticias, setNoticias] = useState([]);

    useEffect(() => {
        const data = new Date().toLocaleDateString('en-CA');
        fetch(`https://sistemasweb.b3.com.br/PlantaoNoticias/Noticias/ListarTitulosNoticias?agencia=18&palavra=${papel}&dataInicial=${data}&dataFinal=${data}`)
            .then(data => {
                setNoticias(data);
            });
    }, [papel]);

    return (
        <div>

        <h1>{ papel.toUpperCase() }</h1>
        {noticias}
        </div>

    )
};