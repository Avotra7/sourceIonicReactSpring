import { Trajet } from './Trajet';
export interface Vehicule{
    id : number,
    marque: string,
    matricule : string,
    listrajet: Trajet[]
}

export default Vehicule;