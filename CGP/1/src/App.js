import { useEffect, useMemo, useState } from "react";
import "./App.css";
import { Block } from "./Block";

function App() {
  const [type, setType] = useState(10);
  const [width, setWidth] = useState(500);
  const [height, setHeight] = useState(400);
  const [active, setActive] = useState(0);
  const style = {
    width: `${width}px`,
    height: `${height}px`,
  };
  const colors = ["#000", "#00f", "#f00", "#0f0"];
  const [blocks, setBlocks] = useState([]);
  const setter = [];
  useMemo(() => {
    for (let i = 0; i < width; i += type) {
      for (let j = 0; j < height; j += type) {
        let rnd = Math.round(Math.random() * 3);
        setter.push({
          width: `${type}px`,
          height: `${type}px`,
          background: `${colors[rnd]}`,
        });
      }
    }
    setBlocks(setter);
  }, [type, width, height]);

  return (
    <div className="App">
      <form>
        <label>
          Введите ширину
          <input
            type="text"
            value={width}
            onChange={(e) => setWidth(e.target.value)}
          />
        </label>
        <label>
          Введите высоту
          <input
            type="text"
            value={height}
            onChange={(e) => setHeight(e.target.value)}
          />
        </label>
        <fieldset>
          <label>
            10x10
            <input
              type="radio"
              onChange={() => {
                setType(10);
                setActive(0);
              }}
              name="type"
              checked={active === 0 ? "checked" : ""}
            />
          </label>
          <label>
            15x15
            <input
              type="radio"
              onChange={() => {
                setType(15);
                setActive(1);
              }}
              name="type"
              checked={active === 1 ? "checked" : ""}
            />
          </label>
          <label>
            20x20
            <input
              type="radio"
              onChange={() => {
                setType(20);
                setActive(2);
              }}
              name="type"
              checked={active === 2 ? "checked" : ""}
            />
          </label>
        </fieldset>
      </form>

      <div className="container">
        <div
          className="mozaic"
          style={{
            display: "flex",
            ...style,
            flexWrap: "wrap",
            alignContent: "center",
          }}
        >
          {blocks.map((obj) => (
            <Block {...obj} />
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;
