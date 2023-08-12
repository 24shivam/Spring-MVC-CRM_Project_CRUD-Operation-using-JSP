import React, { useEffect, useState } from 'react';
//import { makeStyles } from '@mui/material/styles';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container,Paper,Button} from '@mui/material';


// const useStyles = makeStyles((theme) => ({
//     root: {
//       '& > *': {
//         margin: theme.spacing(1),
       
//       },
//     },
//   }));
export default function Student() {
    const paperStyle={ padding: '50px 20px',width:600,margin:"20px auto"}
    const [name,setName]=useState('')
    const [address,setAddress]=useState('')
    const [students,setStudents]=useState([])

    const handleClick=(e)=>{
      e.preventDefault()
      const student={name,address}
      console.log(student)

      fetch("http://localhost:8080/std/save",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(student)

    }).then(()=>{
      console.log ("New Student Added ")
    })
  }
      
     
  useEffect(()=>{
    fetch("http://localhost:8080/std/get")
    .then(res=>res.json())
    .then((result)=>{
      setStudents(result);
    })

  },[]) 
    
    return (
      
      <Container>
      <Paper elevation={3} style={paperStyle}>
          <h1 style={{color:"blue"}}><u>Add Student</u></h1>
      <Box
        component="form"
        sx={{
          '& > :not(style)': { m: 1, width: '25ch' },
        }}
        noValidate
        autoComplete="off"
      >
        <TextField id="outlined-basic" label="Student Name" variant="outlined" fullWidth 
          value={name}
          onChange={(e)=>setName(e.target.value)}
          />
          <TextField id="outlined-basic" label="Student Adress" variant="outlined" fullWidth
          value={address}
          onChange={(e)=>setAddress(e.target.value)}
          />
      </Box>
     
      <Button variant="contained" color="secondary" onClick={handleClick} >
      Submit
    </Button>
      
        </Paper>
        <h1>All Students List</h1>

      
        <Paper elevation={3} style={paperStyle}> 
         

  {students.map(student=>(
    <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={student.id}>
     Id:{student.id}<br/>
     Name:{student.name}<br/>
     Address:{student.address}

    </Paper>
  ))
}

    
</Paper>

    </Container>
  );
}
 

 