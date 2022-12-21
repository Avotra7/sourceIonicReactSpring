import Personne from '../model/Personne';

const personnes: Personne[] =[
    {
        id: 1,
        nom:'Koto',
        prenom:'Naivo'
    },
    {
        id: 2,
        nom:'Lala',
        prenom:'Paul'
    },
    {
        id: 3,
        nom :'Jean',
        prenom:'Claude'
    }

];

export const getPersonne=()=> personnes;

export default getPersonne;