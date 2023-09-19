import React, { useState } from "react";
import { News } from "../components/News";

export const Home = () => {
  const papeis = [
    "xpml",
    "visc",
    "bcff",
    "mxrf",
    "irdm",
    "hglg",
    "xplg",
    "alup",
    "itsa",
    "taee",
    "pssa",
    "klbn",
    "vbbr",
    "csan",
    "vale",
  ];
  const [date, setDate] = useState('');

  const handleDateChange = (e) => {
    const value = e.target.value;
    //const data = new Date(value).toLocaleDateString("en-CA");
    setDate(value);
  };

  return (
    <div>
      <div>
        <input id="date" type="date" onChange={handleDateChange} />
        {date}
      </div>
      <div>
        {papeis.map((papel) => (
          <News papel={papel} key={papel} data={date} />
        ))}
      </div>
    </div>
  );
};
