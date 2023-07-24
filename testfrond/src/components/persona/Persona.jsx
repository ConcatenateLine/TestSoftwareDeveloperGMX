export default function Persona(props) {
    return <li className="mx-auto grid xl:grid-cols-2 text-left"><div>I am { props.persona.nombre } ...!</div> <span className="uppercase">{props.persona.identificacion}</span></li>;
  }