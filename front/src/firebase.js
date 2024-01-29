import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";

const firebaseConfig = {
    apiKey: "AIzaSyAUAuXgYqj6MwJneuFLpgVtM5h-JXNciOU",
    authDomain: "lenoute-1fefd.firebaseapp.com",
    projectId: "lenoute-1fefd",
    storageBucket: "lenoute-1fefd.appspot.com",
    messagingSenderId: "95768995426",
    appId: "1:95768995426:web:69692806f5d3a4219f933b"
  };
  
  const app = initializeApp(firebaseConfig);


  // Initialize Firebase Authentication and get a reference to the service
export const auth = getAuth(app);