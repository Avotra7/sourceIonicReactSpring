import Vehicule from "../model/Vehicule";

export class VehiculeService{
    vehicule!: Vehicule;


    getVehicule(){
        return this.vehicule;
    }

    setVehicule(vehicule: Vehicule){
        this.vehicule = vehicule;
    }

    async getallVehicule():Promise<Vehicule[]>{
        return fetch('http://webserviceflotteavion-production.up.railway.app/vehicule', {       
            method:'GET',
            headers: {'Content-Type': 'application/json'},
        })
        .then(response => response.json())
        .then(data => data);
    }

}

export default VehiculeService;
    
