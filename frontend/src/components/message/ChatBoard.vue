<template>
  <div>
    <el-dialog
      v-bind:title="board_title"
      :visible.sync="localVisible">


      <div v-for="item in messageList">
        <div v-if="item.senderUsername == sender">
          <el-row>
            <el-card style="float: right;background-color: #56ff36">
              <p style="margin: 0px; width: 200px">{{ item.messageContent }}</p>
            </el-card>
          </el-row>
        </div>
        <div v-else>
          <el-row>
            <el-card style="float: left">
              <p style="margin: 0px; width: 200px">{{ item.messageContent }}</p>
            </el-card>
          </el-row>
        </div>
      </div>
      <el-button style="width:10%;float:right" type="primary" @click="connect">连接</el-button>
      <el-input style="width: 70%" v-model="chatContent" placeholder="请输入聊天内容"></el-input>
      <el-button style="width:10%;float:right" type="primary" @click="sendMessage">发送</el-button>
    </el-dialog>
  </div>
</template>

<style>


  p {
    word-break: break-all;
  }

  .talktext p {
    /* remove webkit p margins */
    -webkit-margin-before: 0em;
    -webkit-margin-after: 0em;
  }

</style>

<script>
  // import messageApi from '../../api/message/index'
  import SockJS from 'sockjs-client'
  import Stomp from 'webstomp-client'

  export default {
    name: 'chat-board',
    props: {
      'receiver': String,
      'dialogVisible': Boolean
    },
    watch: {
      dialogVisible (val) {
        this.localVisible = val
        console.log('change listened')
      },
      localVisible (val) {
        if (val === true) {
          // this.connect()
          return
        }
        this.$emit('on-visible-change', val)
      }
    },
    data () {
      return {
        localVisible: this.dialogVisible,
        chatContent: '',
        messageList: []
      }
    },
    computed: {
      board_title: function () {
        return '您当前正在与' + this.receiver + '交流'
      },
      sender: function () {
        return JSON.parse(this.$cookie.get('authorizedUser')).username
      }
    },
    methods: {
      sendMessage: function () {
        console.log('Send message:' + this.chatContent)
        if (this.stompClient) {
          const msg =
            {
              messageContent: this.chatContent,
              senderUsername: this.sender,
              receiverUsername: this.receiver
            }
          this.stompClient.send('/app/sendMessage', JSON.stringify(msg), {})
        }
      },
      connect () {
        this.socket = new SockJS('http://localhost:8080/socket')
        this.stompClient = Stomp.over(this.socket)
        this.stompClient.connect(
          {},
          frame => {
            console.log(frame)
            this.stompClient.subscribe('/queue/chat', tick => {
              console.log(tick)
              this.remsg = JSON.parse(tick.body)
              this.messageList.push({
                senderUsername: this.sender,
                receiverUsername: this.receiver,
                messageContent: this.chatContent
              })
            })
          },
          error => {
            console.log(error)
          }
        )
      }
    }
  }
</script>
