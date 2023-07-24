import { useState } from 'react';
import axios from 'axios';
import { minChartErrorValidation, minLetterErrorValidation} from "../../utils/FormErrorValidation";

export default function Create(props) {
    
    const [nombre, setNombre] = useState("");
    const [apellidoPaterno, setApellidoPaterno] = useState("");
    const [apellidoMaterno, setApellidoMaterno] = useState("");
    const [identificacion, setIdentificacion] = useState("");

    const isErrorNombre = minLetterErrorValidation(nombre);
    const isErrorApellidoPaterno = minLetterErrorValidation(apellidoPaterno);
    const isErrorIdentificacion = minChartErrorValidation(identificacion);

    const valide = isErrorNombre || isErrorApellidoPaterno || isErrorIdentificacion;

    const sumitForm = (event)  => {
        event.preventDefault();        
        if(!valide){            
            const persona = {
                nombre: nombre,
                apellidoPaterno: apellidoPaterno,
                apellidoMaterno: apellidoMaterno,
                identificacion: identificacion,
            };

            axios.post(`/api/directorio`, persona )
            .then(res => {
                props.onUpdate(true);
            })
        }
    }


    return (
        <form className="w-full max-w-lg" onSubmit={sumitForm}>
        <div className="flex flex-wrap -mx-3 mb-6">
          <div className="w-full md:w-1/1 px-3 mb-6 md:mb-0">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="grid-first-name">
              {isErrorNombre? <span>Agrega un nombre valido !</span> : <span  className='text-green-800'>Nombre aceptado.!</span>}
            </label>
            <p className="text-red-500 text-xs italic">requerido</p>
            <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" id="nombre" type="text" placeholder="Jane" onChange={(e) => setNombre(e.target.value)}/>
          </div>
          <div className="w-full md:w-1/1 px-3">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="grid-last-name">              
              {isErrorApellidoPaterno? <span>Agrega un Apellido Paterno valido!</span> : <span className='text-green-800'>Apellido Paterno aceptado.!</span>}
            </label>
            <p className="text-red-500 text-xs italic">requerido</p>
            <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="apellidoPaterno" type="text" placeholder="Doe" onChange={(e) => setApellidoPaterno(e.target.value)}/>            
          </div>
          <div className="w-full md:w-1/1 px-3">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="grid-last-name">
              Apellido Materno
            </label>
            <p className="text-blue-500 text-xs italic">obcional</p>
            <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="nameapellidoMaterno" type="text" placeholder="Doe" onChange={(e) => setApellidoMaterno(e.target.value)}/>            
          </div>
        </div>
        <div className="flex flex-wrap -mx-3 mb-6">
          <div className="w-full px-3">
            <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="grid-password">
              {isErrorIdentificacion? <span>Agrega una Identificacion valida!</span> : <span className='text-green-800'>Identificacion aceptada.!</span>}
            </label>
            <p className="text-red-500 text-xs italic">requerido</p>
            <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="identificacion" type="text" placeholder="Doe" onChange={(e) => setIdentificacion(e.target.value)}/>            
          </div>
        </div>
        <button className="flex-shrink-0 bg-teal-500 hover:bg-teal-700 border-teal-500 hover:border-teal-700 text-sm border-4 text-white py-1 px-2 rounded" type="submit" >
            Enviar
        </button>
      </form>
    );
  }