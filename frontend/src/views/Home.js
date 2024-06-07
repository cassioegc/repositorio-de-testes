import React, { useState } from "react";
import { News } from "../components/News";

export const Home = () => {
  const papeis = [
    "alzm",
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
    "prio",
  ];
  const [date, setDate] = useState(new Date().toLocaleDateString("en-CA"));

  const handleDateChange = (e) => {
    const value = e.target.value;
    setDate(value);
  };

  return (
    <div>
      <div style={{ margin: "10px 0 10px 0" }}>
        <input id="date" type="date" onChange={handleDateChange} value={date} style={{
          borderStyle: "double",
          borderColor: "var(--bs-heading-color)",
          borderRadius: "10px",
          textAlign: "center"
        }} />
      </div>
      <div>
        {papeis.map((papel) => (
          <News papel={papel} key={papel} data={date} />
        ))}
      </div>
    </div>
  );
};
