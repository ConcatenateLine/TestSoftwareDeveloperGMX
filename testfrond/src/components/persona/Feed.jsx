import CrearPerson from "./Create";
import PersonList from "./List"
import React, { useState, useEffect } from "react";
import axios from 'axios';

export default function Feed() {
    
  const [personas, setPersonas] = useState([]);
  const [update, setUpdate] = useState(false);

  useEffect(() => {
      axios.get(`/api/directorio`)
        .then(res => {
          setPersonas(res.data);
          setUpdate(false);
        })
  },[update]);

    return (
        <div className="mx-auto grid max-w-7xl gap-x-8 gap-y-20 px-6 lg:px-8 xl:grid-cols-2">
            <CrearPerson onUpdate={setUpdate} />
            <PersonList personas={personas} />
      </div>  
    )
}