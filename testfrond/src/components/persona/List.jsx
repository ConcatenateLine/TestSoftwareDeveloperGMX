import Persona from "./Persona";
export default function List(props) {
    return (
      <ul>
        <li className="mx-auto grid xl:grid-cols-2 mt-2 mb-4 text-left"><div>Nombre: </div> <p>Identificacion</p></li>
        { props.personas.map(person => <Persona key={person.id} persona={person}/>)}
      </ul>
    )
}