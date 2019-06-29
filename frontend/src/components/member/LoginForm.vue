<template>
<div>
  <Nav></Nav>
  <form>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>
    <button class="btn btn-default" @click="get">조 회</button>
    <button class="btn btn-default" @click="post">입 력</button>
    <button class="btn btn-default" @click="put">수 정</button>
    <button class="btn btn-default" @click="del">삭 제</button>
    
    <button class="btn btn-default" @click="post">등록</button>
  </form>
  <Footer></Footer>
</div>
</template>

<script>
import Nav from '@/components/common/Nav.vue'
import Footer from'@/components/common/Footer.vue'
import axios from 'axios'

export default {
  data(){
    return {
      context :'http://localhost:9000',
    }
    
  },
  components: {
    Nav,
    Footer
  },
  methods:{
      get(){
         axios.get(`${this.context}/customers/count`)
         .then(res=>{
             alert(`SUCESS2:${res.data}`)
         })
         .catch(res=>{
             alert('ERROR')
         })
        
      },
      post(){
        var data = {
          id   : document.getElementById("email").value,
          pass : document.getElementById("pwd").value
        }
        axios.post(`${this.context}/customers/join`, data)
        .then(res=>{
          alert(`POST 연동성공: ${res.data.result}`)
        })
        .catch(res=>{
             alert('ERROR')
         })
        // alert(document.getElementById("email").value);
        // alert(`${this.id}`);
      },
      put(){
        axios.put('/customers/id')
        .then(d=>{
          alert(`PUT 연동성공: ${d.data.result}`)
        })
      },
      del(){
        axios.delete('/customers/id')
        .then(d=>{
          alert(`DEL 연동성공: ${d.data.result}`)
        })
      }


  }
}
</script>

<style scoped>
</style>