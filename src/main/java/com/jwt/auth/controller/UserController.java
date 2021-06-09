package com.jwt.auth.controller;

import com.jwt.auth.claims.model.ClaimBookings;
import com.jwt.auth.claims.model.ClaimPerils;
import com.jwt.auth.claims.repo.ClaimBookingRepo;
import com.jwt.auth.claims.repo.ClaimPerilRepo;
import com.jwt.auth.model.AuthRequest;
import com.jwt.auth.model.AuthResponse;
import com.jwt.auth.model.MotorFormBean;
import com.jwt.auth.model.User;
import com.jwt.auth.mpesa.*;
import com.jwt.auth.quotes.*;
import com.jwt.auth.repo.*;
import com.jwt.auth.service.SystemUserDetails;
import com.jwt.auth.trans.model.ReceiptTransDtls;
import com.jwt.auth.trans.repo.ReceiptDetailsRepo;
import com.jwt.auth.util.JwtUtil;
import com.jwt.auth.uw.model.*;
import com.jwt.auth.uw.model.QuoteDetailsBean;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
    String d="";

    private JwtUtil jwtUtil;
    private AuthenticationProvider authenticationProvider;
    private SystemUserDetails mySystemUserDetails;
    private UserRepo userRepo;
    private ClientRepo clientRepo;
    private PolicyRepo policyRepo;
    private QuotesRepo quotesRepo;
    private QuoteProRepo quoteProRepo;
    private RiskTransRepo riskTransRepo;
    private ReceiptDetailsRepo receiptDetailsRepo;
    private ClaimBookingRepo claimBookingRepo;
    private ClaimPerilRepo claimPerilRepo;
    private QuoteRiskRepo quoteRiskRepo;
    private InsuranceProductsRepo insuranceProductsRepo;
    private AddOnRepo addOnRepo;
    private BinderDefRepo binderRepo;
    private AccountRepo accountRepo;
    private BinDerRepo binDerRepo;
    private CovertypesRepo covertypesRepo;
    private SubClassRepo subClassRepo;
    private RestTemplate restTemplate;
    private MpesaRepo mpesaRepo;


    public UserController(JwtUtil jwtUtil, AuthenticationProvider authenticationProvider, SystemUserDetails mySystemUserDetails, UserRepo userRepo, ClientRepo clientRepo, PolicyRepo policyRepo, QuotesRepo quotesRepo, QuoteProRepo quoteProRepo, RiskTransRepo riskTransRepo, ReceiptDetailsRepo receiptDetailsRepo, ClaimBookingRepo claimBookingRepo, ClaimPerilRepo claimPerilRepo, QuoteRiskRepo quoteRiskRepo, InsuranceProductsRepo insuranceProductsRepo, AddOnRepo addOnRepo, BinderDefRepo binderRepo, AccountRepo accountRepo, BinDerRepo binDerRepo, CovertypesRepo covertypesRepo, SubClassRepo subClassRepo, RestTemplate restTemplate, MpesaRepo mpesaRepo) {
        this.jwtUtil = jwtUtil;
        this.authenticationProvider = authenticationProvider;
        this.mySystemUserDetails = mySystemUserDetails;
        this.userRepo = userRepo;
        this.clientRepo = clientRepo;
        this.policyRepo = policyRepo;
        this.quotesRepo = quotesRepo;
        this.quoteProRepo = quoteProRepo;
        this.riskTransRepo = riskTransRepo;
        this.receiptDetailsRepo = receiptDetailsRepo;
        this.claimBookingRepo = claimBookingRepo;
        this.claimPerilRepo = claimPerilRepo;
        this.quoteRiskRepo = quoteRiskRepo;
        this.insuranceProductsRepo = insuranceProductsRepo;
        this.addOnRepo = addOnRepo;
        this.binderRepo = binderRepo;
        this.accountRepo = accountRepo;
        this.binDerRepo = binDerRepo;
        this.covertypesRepo = covertypesRepo;
        this.subClassRepo = subClassRepo;
        this.restTemplate = restTemplate;
        this.mpesaRepo = mpesaRepo;
    }

    @GetMapping("/hello")
    public String welcome(){
        return "Welcome to Gabu Dev";
    }

    @GetMapping("clients/{code}")
    public String getClient( @PathVariable Long code){
       ClientDef client=clientRepo.findByTenId(code);
       String gender=client.getGender().equalsIgnoreCase("M")?"Male":"Female";
       JSONObject json= new JSONObject();
       json.put("clientId",client.getTenId());
       json.put("salutation",client.getClientTitle().getTitleName());
       json.put("fname",client.getFname());
       json.put("oname",client.getOtherNames());
       json.put("gender",gender);
       json.put("born",client.getDob());
       json.put("email",client.getEmailAddress());
       json.put("phone",client.getPhoneNo());
       json.put("clientNo",client.getTenantNumber());
       return json.toString();
    }
    @GetMapping("policies/{code}")
    public ResponseEntity<List<ClientPolicy>> getPolicy(@PathVariable ClientDef code){
     //   List<PolicyTrans> policies=policyRepo.findByClientAndPolicyIdGreaterThanAndAuthStatus(code, 184008L,"A");
        List<PolicyTrans> policies=policyRepo.findByClientAndAuthStatus(code, "A");

        List<ClientPolicy> cp=new ArrayList<>();
        ListWrapper wrapper=new ListWrapper();
        BigDecimal pr=BigDecimal.valueOf(7125);
        for(PolicyTrans p: policies){
         ClientPolicy policy=new ClientPolicy();
         String auth="";
         if(p.getAuthStatus()!=null) {
             if (p.getAuthStatus().equalsIgnoreCase("A")) {
                 auth = "Authorised";
             }
             else if (p.getAuthStatus().equalsIgnoreCase("R")){
                 auth="Ready";
             }
             else{
                 auth="Draft";
             }
         }
         policy.setPolicyId(p.getPolicyId());
         policy.setPolicyNo(p.getPolNo());
         policy.setProduct(p.getProduct().getProDesc());
         policy.setStatus(auth);
         cp.add(policy);

        }

      return ResponseEntity.ok(cp);


    }

    @GetMapping("risks/{code}")
    public ResponseEntity<List<RiskBean>> getPolicyRisk(@PathVariable PolicyTrans code){
        List<RiskTrans> riskTrans=riskTransRepo.findByPolicy(code);
        List<RiskBean> cp=new ArrayList<>();
        for(RiskTrans p: riskTrans){
            RiskBean risk=new RiskBean();
            String auth="";
            risk.setRiskId(p.getRiskId());
            risk.setRiskDesc(p.getRiskDesc());
            risk.setDescription(p.getRiskShtDesc());
            risk.setPremium(p.getPremium());
            risk.setSumInsured(p.getSumInsured());
            cp.add(risk);

        }


        return ResponseEntity.ok(cp);
    }

    @GetMapping("/countQuotes/{cover}")
    public ResponseEntity<QuoteCount> getCount(@PathVariable String cover){

        if(cover!=null) {
            if (cover.equalsIgnoreCase("Comprehensive")) {

                cover = "Comprehensive";

            } else if (cover.equalsIgnoreCase("Third Party Only")) {

                cover = "TPO";

            } else {
                cover = "0";
            }
        }
        else {
            cover="O";
        }

        QuoteCount quoteCount=new QuoteCount();
        Long count=insuranceProductsRepo.countByCoverContainsIgnoreCase(cover);
        quoteCount.setQuoteCount(count);
        return ResponseEntity.ok(quoteCount);
    }

    @PostMapping("selfquotes")
    public ResponseEntity<List<SelfQuoteBean>> getSelfQuotes(@RequestBody MotorFormBean motorFormBean){
        List<InsuranceQuotes> insuranceQuotes=new ArrayList<>();
        if(motorFormBean.getCover().equalsIgnoreCase("Comprehensive")){
            insuranceQuotes=insuranceProductsRepo.findByCover("Comprehensive");

        }
        else if(motorFormBean.getCover().equalsIgnoreCase("Third Party Only")){
            insuranceQuotes=insuranceProductsRepo.findByCoverContainsIgnoreCase("TPO");

        }
        else {
            insuranceQuotes=insuranceProductsRepo.findAll();
        }
        List<SelfQuoteBean> cp=new ArrayList<>();
        List<AddOnBean> addOnBeans=new ArrayList<>();
        for(InsuranceQuotes p: insuranceQuotes){
            BigDecimal premium=BigDecimal.ZERO;
            SelfQuoteBean quoteBean=new SelfQuoteBean();
            String pt="";
            List<AddOns> addOns=addOnRepo.findByInsuranceQuotes(p);
           /* for (AddOns a:addOns){
                AddOnBean addOnBean=new AddOnBean();
                addOnBean.setAddOnCode(a.getAddOnCode());
                addOnBean.setAddOnName(a.getAddOnName());
                addOnBean.setAddOnPrice(a.getAddOnPrice());
                addOnBeans.add(addOnBean);
            }
            */
            quoteBean.setQuoteAddOns(addOns);
            quoteBean.setSelfQuoteId(p.getQuoteId());
            quoteBean.setCover(p.getCover());
            if(p.getInsuranceCompany().getCompany().contains(" ")){
                quoteBean.setName(p.getInsuranceCompany().getCompany());
            }
            else{
                quoteBean.setName(p.getInsuranceCompany().getCompany()+" Insurance");
            }
            if(p.getInsuranceCompany().getCompany().contains("CIC")){

                pt=motorFormBean.getValue().replaceAll(",","");
                double prem=Double.parseDouble(pt);

                BigDecimal dec=BigDecimal.valueOf(prem);
                premium=(BigDecimal.valueOf(3).divide(BigDecimal.valueOf(100))).multiply(dec);
                premium=premium.setScale(2, RoundingMode.CEILING);

            }
            else{
                pt=motorFormBean.getValue().replaceAll(",","");

                double prem=Double.parseDouble(pt);
                BigDecimal dec=BigDecimal.valueOf(prem);
                premium=(BigDecimal.valueOf(4).divide(BigDecimal.valueOf(100))).multiply(dec);
                premium=premium.setScale(2, RoundingMode.CEILING);
            }
            quoteBean.setPremium(premium.toString()+" Ksh");
            quoteBean.setSumInsured(pt+".00");

            cp.add(quoteBean);

        }


        return ResponseEntity.ok(cp);
    }


    @PostMapping("buyInsurance")
    public ResponseEntity<ResponseBean> buyInsurance(@RequestBody BuyInsuranceBean buyInsuranceBean) throws ParseException {

        PolicyTrans policy=new PolicyTrans();
        policy.setStatus("A");
        String premium=buyInsuranceBean.getPremium().replaceAll(",","");
        premium=premium.replaceAll("Ksh ","");
        double prem=Double.parseDouble(premium);
        BigDecimal bg=BigDecimal.valueOf(prem);
        String sum=buyInsuranceBean.getValue().replaceAll(",","");
        double s=Double.parseDouble(sum);
        BigDecimal val=BigDecimal.valueOf(s);
        policy.setBasicPrem(bg);
        policy.setAuthStatus("A");
        policy.setSumInsured(val);

        ClientDef clientDef=clientRepo.findByTenId(buyInsuranceBean.getClientId());
        policy.setClient(clientDef);
        policy.setBusinessType("Android");


        String sDate1=buyInsuranceBean.getStartDate();
        sDate1=sDate1.substring(sDate1.lastIndexOf(" ") + 1);
        String wDate1=buyInsuranceBean.getCoverLength();

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(wDate1);


        policy.setCoverFrom(date1);
        policy.setCoverTo(date2);
        String company=buyInsuranceBean.getCompany();
        String binder=buyInsuranceBean.getBinder();
        company=company.substring(0, company.indexOf(' '));
        AccountDef accountDef=accountRepo.findByShtDescContainsIgnoreCase(company);

        policy.setAgent(accountDef);
        BindersDef def =new BindersDef();
        BinderDetails det=new BinderDetails();
        if(binder.equalsIgnoreCase("PRIVATE")){
            binder=accountDef.getShtDesc()+" Motor Private";
            def=binderRepo.findByBinNameContainsIgnoreCase(binder);
            det=binDerRepo.findFirstByBinder(def);

        }
        CoverTypesDef cover=new CoverTypesDef();
        cover=covertypesRepo.findFirstByCovNameContainsIgnoreCase(buyInsuranceBean.getCover());
        policy.setBinder(def);

        policy.setWefDate(date1);
        policy.setWetDate(date2);
       /* DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate=LocalDate.parse(sDate1,df);
        localDate=localDate.plusMonths(Long.parseLong(buyInsuranceBean.getCoverLength()));
        ZoneId defaultZoneId = ZoneId.systemDefault();

        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        policy.setWetDate(date);

        */
        policy.setPremium(bg);
        policy.setProduct(def.getProduct());
        String vehicle=buyInsuranceBean.getVehicle().replaceAll(" ","");
        policy.setPolNo("AND-MP/"+vehicle+"/"+clientDef.getTenId());
        policy.setPolRevNo(vehicle+"/"+clientDef);
        policy.setPolRevStatus("Android");
        policy.setRenewalDate(date2);
        policy.setPolCreateddt(date1);
        User user=userRepo.findByUserId(buyInsuranceBean.getClientId());
        policy.setCreatedUser(user);


        PolicyTrans policyTrans=policyRepo.save(policy);


        RiskTrans riskTrans=new RiskTrans();
        SubClassDef subClassDef=new SubClassDef();
        subClassDef=subClassRepo.findFirstBySubDescContainsIgnoreCase("Motor Private");
        riskTrans.setBinder(def);
        riskTrans.setBinderDetails(det);
        riskTrans.setRiskDesc(buyInsuranceBean.getVehicle());
        riskTrans.setRiskDesc(buyInsuranceBean.getModel());
        riskTrans.setRiskShtDesc(buyInsuranceBean.getVehicle());
        riskTrans.setInsured(clientDef);
        riskTrans.setPolicy(policyTrans);
        riskTrans.setPremium(bg);
        riskTrans.setWefDate(date1);
        riskTrans.setWetDate(date2);
        riskTrans.setSumInsured(val);
        riskTrans.setCovertype(cover);
        riskTrans.setSubclass(subClassDef);
        riskTransRepo.save(riskTrans);
        ResponseBean response=new ResponseBean();
        response.setMessage("Successful");


        return ResponseEntity.ok(response);
    }


    @GetMapping("quoterisks/{code}")
    public ResponseEntity<List<RiskBean>> quoterisks(@PathVariable QuoteTrans code){
        List<QuoteRiskTrans> riskTrans=quoteRiskRepo.findByProductTrans_QuoteTrans(code);
        List<RiskBean> cp=new ArrayList<>();
        for(QuoteRiskTrans p: riskTrans){
            RiskBean risk=new RiskBean();
            String auth="";

            risk.setRiskId(p.getRiskId());
            risk.setRiskDesc(p.getRiskDesc());
            risk.setDescription(p.getRiskShtDesc());
            risk.setPremium(p.getPremium());
            risk.setSumInsured(p.getSumInsured());
            cp.add(risk);

        }


        return ResponseEntity.ok(cp);
    }
    @GetMapping("receipts/{code}")
    public ResponseEntity<List<ReceiptBean>> getPolicyReceipts(@PathVariable PolicyTrans code){
        List<ReceiptTransDtls> receipts=receiptDetailsRepo.findByPolicy(code);
        List<ReceiptBean> cp=new ArrayList<>();
        for(ReceiptTransDtls p: receipts){
            ReceiptBean bean=new ReceiptBean();
            String s="";
            bean.setAmmount(p.getRctAmount());
            bean.setReceiptNo(p.getReceipt().getReceiptNo());
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            if(p.getReceipt().getReceiptDate()!=null) {
                s = dateFormat.format(p.getReceipt().getReceiptDate());
            }
            bean.setDatePaid(s);
            bean.setRefNo(p.getReceipt().getPaymentRef());
            if(p.getRctDC()!=null) {
                if(p.getRctDC().equalsIgnoreCase("C")) {
                    bean.setDebitCredit("Credit");
                }
                else{
                    bean.setDebitCredit("Debit");
                }
            }
            bean.setReceiptId(p.getReceiptId());
            cp.add(bean);

        }


        return ResponseEntity.ok(cp);
    }
    @GetMapping("claims/{code}")
    public ResponseEntity<List<ClaimsBean>> getPolicyClaims(@PathVariable PolicyTrans code){

        List<ClaimBookings> claims=claimBookingRepo.findByRisk_Policy(code);
        List<ClaimsBean> cp=new ArrayList<>();
        for(ClaimBookings p: claims){
            ClaimsBean bean=new ClaimsBean();
            ClaimPerils claimPerils=claimPerilRepo.findByClaimBookings(p);
            String s="";
            String q="";
            bean.setClaimId(p.getClmId());
            bean.setClaimNo(p.getClaimNo());
            bean.setPeril(claimPerils.getBinderSectionPerils().getSubclassPeril().getPeril().getPerilDesc());
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            if(p.getLossDate()!=null) {
                s = dateFormat.format(p.getLossDate());
            }
            if(p.getClmDate()!=null) {
                q = dateFormat.format(p.getClmDate());
            }
            bean.setClaimDate(q);
            bean.setLossDate(s);
            if(p.getClaimStatus()!=null) {
                if(p.getClaimStatus().equalsIgnoreCase("O")) {
                    bean.setStatus("Open");
                }
                else{
                    bean.setStatus("Closed");
                }
            }
            cp.add(bean);

        }


        return ResponseEntity.ok(cp);
    }

    @GetMapping("myquotes/{code}")
    public ResponseEntity<List<QuotesBean>> getPolicyClaims(@PathVariable ClientDef code){

        List<QuoteTrans> claims=quotesRepo.findByClientAndQuotStatus(code,"A");
        List<QuotesBean> cp=new ArrayList<>();
        for(QuoteTrans p: claims){
            QuotesBean bean=new QuotesBean();
           // ClaimPerils claimPerils=claimPerilRepo.findByClaimBookings(p);
            String s="";
            String q="";
            bean.setQuoteId(p.getQuoteId());
            bean.setQuoteNo(p.getQuotNo());
            QuoteProTrans quoteProTrans=quoteProRepo.findByQuoteTrans(p);
            bean.setProduct(quoteProTrans.getProduct().getProDesc());

            if(p.getQuotStatus()!=null) {
                if(p.getQuotStatus().equalsIgnoreCase("A")) {
                    bean.setStatus("Authorized");
                }
                else if(p.getQuotStatus().equalsIgnoreCase("CL")){
                    bean.setStatus("Cancelled");
                }
                else{
                    bean.setStatus("Draft");
                }
            }
            cp.add(bean);

        }


        return ResponseEntity.ok(cp);
    }

    @GetMapping("policy/{code}")
    public ResponseEntity<PolicyDetails> getPolicy(@PathVariable Long code) throws Exception {
        PolicyTrans p=policyRepo.findByPolicyId(code);
        if(p==null)
            throw new Exception(
                    "No such Policy Exists"
            );
        PolicyDetails policy=new PolicyDetails();
        String coverFrom="";
        String coverTo="";
        String renewal="";
        double balance= 0;

        if(p.getPolNo().contains("AND")){
           balance=p.getPremium().doubleValue();
       }
        else{
            balance= code * 0.37 + 5340;

        }

            String auth="";

            if(p.getAuthStatus()!=null) {
                if (p.getAuthStatus().equalsIgnoreCase("A")) {
                    auth = "Authorised";
                }
                else if (p.getAuthStatus().equalsIgnoreCase("R")){
                    auth="Ready";
                }
                else{
                    auth="Draft";
                }
            }
            policy.setPolicyId(p.getPolicyId());
            policy.setPolicyNo(p.getPolNo());
            policy.setProduct(p.getProduct().getProDesc());
            policy.setStatus(auth);
            policy.setBalance(String.valueOf(balance));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            if(p.getCoverFrom()!=null) {
                coverFrom = dateFormat.format(p.getWefDate());
            }
            if(p.getCoverTo()!=null) {
                coverTo = dateFormat.format(p.getWetDate());
            }
            if(p.getRenewalDate()!=null) {
                renewal = dateFormat.format(p.getRenewalDate());
            }
            policy.setCoverFrom(coverFrom);
            policy.setCoverTo(renewal);
            policy.setRenewalDate(renewal);



        return ResponseEntity.ok(policy);


    }
    @GetMapping("quotedetails/{code}")
    public ResponseEntity<QuoteDetailsBean> getQuote(@PathVariable Long code) throws Exception {
        QuoteTrans p=quotesRepo.findByQuoteId(code);
        if(p==null)
            throw new Exception(
                    "No such Quote Exists"

            );
        QuoteDetailsBean quote=new QuoteDetailsBean();
        String coverFrom="";
        String coverTo="";
        String expiry="";

        double balance= code * 0.37 + 5340;

        String auth="";

        if(p.getQuotStatus()!=null) {
            if (p.getQuotStatus().equalsIgnoreCase("A")) {
                auth = "Authorised";
            }
            else if (p.getQuotStatus().equalsIgnoreCase("CL")){
                auth="Cancelled";
            }
            else{
                auth="Draft";
            }
        }
        QuoteProTrans quoteProTrans=quoteProRepo.findByQuoteTrans(p);
        quote.setProduct(quoteProTrans.getProduct().getProDesc());
        quote.setQuoteId(p.getQuoteId());
        quote.setQuoteNo(p.getQuotNo());
        quote.setStatus(auth);
        quote.setAmmount(String.valueOf(balance));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(p.getWefDate()!=null) {
            coverFrom = dateFormat.format(p.getWefDate());
        }
        if(p.getWetDate()!=null) {
            coverTo = dateFormat.format(p.getWetDate());
        }
        if(p.getExpiryDate()!=null) {
            expiry = dateFormat.format(p.getExpiryDate());
        }
        quote.setCoverFrom(coverFrom);
        quote.setCoverTo(coverTo);
        quote.setExpiry(expiry);



        return ResponseEntity.ok(quote);


    }
    @GetMapping("quotes/{code}")
    @ResponseBody
    public List<ClientQuotes> getQuotes(@PathVariable ClientDef code){
        List<QuoteTrans> policies=quotesRepo.findByClient(code);
        List<ClientQuotes> cp=new ArrayList<>();

        for(QuoteTrans p: policies){
            QuoteProTrans qp=quoteProRepo.findByQuoteTrans(p);
            ClientQuotes policy=new ClientQuotes();
            String auth="";
            if(p.getQuotStatus()!=null) {
                if (p.getQuotStatus().equalsIgnoreCase("A")) {
                    auth = "Authorised";
                }
                else if (p.getQuotStatus().equalsIgnoreCase("CL")){
                    auth="Cancelled";
                }
                else{
                    auth="Draft";
                }
            }
            policy.setQuoteId(p.getQuoteId());
            policy.setQuoteNo(p.getQuotNo());
            policy.setPremium(p.getPremium());
            policy.setProduct(qp.getProduct().getProDesc());
            policy.setSumInsured(p.getSumInsured());
            policy.setStatus(auth);
            policy.setUnderwriter(qp.getAgent().getName());
            policy.setExpiry(p.getExpiryDate());

            cp.add(policy);
        }


        return cp;

    }
    @GetMapping("riskBeans/{code}")
    @ResponseBody
    public List<PolicyRisks> getRisks(@PathVariable PolicyTrans code){
        List<RiskTrans> policies=riskTransRepo.findByPolicy(code);
        List<PolicyRisks> cp=new ArrayList<>();

        for(RiskTrans p: policies){
            PolicyRisks policy=new PolicyRisks();
            String auth="";
            policy.setRiskId(p.getRiskId());
            policy.setRiskDesc(p.getRiskDesc());
            policy.setPremium(p.getPremium());
            policy.setRiskShtDesc(p.getRiskShtDesc());
            policy.setSumInsured(p.getSumInsured());
            policy.setWef(p.getWefDate());
            policy.setWet(p.getWetDate());


            cp.add(policy);
        }


        return cp;

    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authenticationRequest) throws Exception {
        try {
            authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        UserDetails userDetails= mySystemUserDetails.loadUserByUsername(authenticationRequest.getUsername());
        User user=userRepo.findByUsername(authenticationRequest.getUsername());
        ClientDef def=clientRepo.findByTenId(user.getUserClient());
        String phone=def.getOfficeTel();
        if(phone.startsWith("0")){
            phone=phone;
        }
        else{
            phone="0"+phone;
        }

        String realName="HELLO "+def.getFname().toUpperCase()+" "+def.getOtherNames().toUpperCase();

        final String jwt=jwtUtil.generateToken(userDetails);
        List<String> roles=userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok(new AuthResponse(jwt,userDetails.getUsername(),"Bearer ", realName, user.getUserClient(), roles, 0, 11, 3, phone));
    }

    @GetMapping("/registerUrl")
    public String register(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ShortCode","600000");
        jsonObject.put("ResponseType","Confirmed");
        jsonObject.put("ConfirmationURL","https://53ab9142a57d.ngrok.io/confirmUrl");
        jsonObject.put("ValidationURL","https://e350a58d406a.ngrok.io/validateUrl");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken());
        HttpEntity<String> request =
                new HttpEntity<>(jsonObject.toString(), headers);
        String url="https://sandbox.safaricom.co.ke/mpesa/c2b/v1/registerurl";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        return response.getBody();
    }
    @PostMapping("confirmUrl")
    public ResponseEntity<String> confirmUrl(@RequestBody String transDetails){
        System.out.println("Confirmation url.... "+transDetails);
        JSONObject jsonObject = new JSONObject(transDetails);
        C2BPaymentDetails c=new C2BPaymentDetails();
        c.setTransactionType(jsonObject.getString("TransactionType"));
        c.setTransID(jsonObject.getString("TransID"));
        c.setTransTime(jsonObject.getString("TransTime"));
        c.setTransAmount(jsonObject.getString("TransAmount"));
        c.setBusinessShortCode(jsonObject.getString("BusinessShortCode"));
        c.setBillRefNumber(jsonObject.getString("BillRefNumber"));
        c.setInvoiceNumber(jsonObject.getString("InvoiceNumber"));
        c.setOrgAccountBalance(jsonObject.getString("OrgAccountBalance"));
        c.setThirdPartyTransID(jsonObject.getString("ThirdPartyTransID"));
        c.setmSISDN(jsonObject.getString("MSISDN"));
        c.setFirstName(jsonObject.getString("FirstName"));
        c.setMiddleName(jsonObject.getString("MiddleName"));
        c.setLastName(jsonObject.getString("LastName"));
        mpesaRepo.save(c);
        return new ResponseEntity<String>("success", HttpStatus.OK);


    }
    @RequestMapping(value = "validateUrl", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String validateUrl(@RequestBody String transactions) throws org.json.simple.parser.ParseException, ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(transactions);
        JSONObject json = new JSONObject(obj.toString());



        System.out.println("Validation url.... "+transactions);

        JSONArray jsonArray=json.getJSONObject("Body")
                .getJSONObject("stkCallback").getJSONObject("CallbackMetadata").
                        getJSONArray("Item");

        List<StkCredentials> map = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject cred = jsonArray.getJSONObject(i);
            System.out.println(cred.toString());
            if(cred.has("Value")){

                StkCredentials stkCredentials=new StkCredentials();
                stkCredentials.setKey(cred.getString("Name"));
                stkCredentials.setValue(cred.get("Value").toString());
                map.add(stkCredentials);

            }
            else{

                StkCredentials stkCredentials=new StkCredentials();
                stkCredentials.setKey(cred.getString("Name"));
                stkCredentials.setValue("N/A");
                map.add(stkCredentials);
            }

        }
        StkReceipts stkDtls=new StkReceipts();
        for (StkCredentials stk:map){

            System.out.println(stk.getKey()+","+stk.getValue());

            if(stk.getKey().equalsIgnoreCase("Amount")){
                stkDtls.setAmmount(stk.getValue());
            }
            else if(stk.getKey().equalsIgnoreCase("MpesaReceiptNumber")){
                stkDtls.setReceiptNo(stk.getValue());

            }
            else if(stk.getKey().equalsIgnoreCase("Balance")){
                stkDtls.setBalance(stk.getValue());

            }
            else if(stk.getKey().equalsIgnoreCase("TransactionDate")){
                Date date=new SimpleDateFormat("yyyyMMddHHmmss").parse(stk.getValue());
                //stkDtls.setBalance(stk.getValue());
                String d=new SimpleDateFormat("dd/MM/yyyy").format(date);
                stkDtls.setDatePaid(d);

            }
            else if(stk.getKey().equalsIgnoreCase("PhoneNumber")){
                stkDtls.setPhone(stk.getValue());

            }

        }
        System.out.print("Receipt "+stkDtls.getReceiptNo()+" Phone "+stkDtls.getPhone()+" Ammount "+stkDtls.getAmmount()+" Balance "+stkDtls.getBalance());

        JSONObject jo = new JSONObject();
        jo.put("ResultCode",0);
        jo.put("ResultDesc", "Validation Successful");
        return jo.toString();

    }


    public String authToken(){
        String u="5qBZOKMtqhG2QG2G1ALTUCANs9kkMmx5";
        String p="PK5XnBGl3S20Xs4v";
        String credentials=u+":"+p;
        byte[] bytes=credentials.getBytes(StandardCharsets.ISO_8859_1);
        String auth= Base64.getEncoder().encodeToString(bytes);
        String authHeader = "Basic " + auth;
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.set("Authorization", authHeader);
        httpHeaders.set("cache-control","no-cache");
        HttpEntity<String> request = new HttpEntity<>(httpHeaders);
        String url="https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";
        ResponseEntity<MpesaToken> response = restTemplate.exchange(url, HttpMethod.GET, request, MpesaToken.class);

        return Objects.requireNonNull(response.getBody()).getAccess_token();
    }

    public String authStkPush(){
        String u="sMpgnYW62glBlxPXbyTBEGdPib8eJLOL";
        String p="IcK2PkAFArVVVffU";
        String credentials=u+":"+p;
        byte[] bytes=credentials.getBytes(StandardCharsets.ISO_8859_1);
        String auth= Base64.getEncoder().encodeToString(bytes);
        String authHeader = "Basic " + auth;
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.set("Authorization", authHeader);
        httpHeaders.set("cache-control","no-cache");
        HttpEntity<String> request = new HttpEntity<>(httpHeaders);
        String url="https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";
        ResponseEntity<MpesaToken> response = restTemplate.exchange(url, HttpMethod.GET, request, MpesaToken.class);

        return Objects.requireNonNull(response.getBody()).getAccess_token();
    }

    @GetMapping("/saveMyMoney")
    public void getCredets() {
        JSONObject json = new JSONObject();
        json.put("name", "Kim");
        json.put("age", "Twenty");

        JSONObject json1 = new JSONObject();
        json1.put("name", "Kong");
        json1.put("age", "Twenty");

        JSONObject json2 = new JSONObject();
        json2.put("name", "Kelly");
        json2.put("age", "Twenty");

        JSONObject json3 = new JSONObject();
        json3.put("name", "King");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(json);
        jsonArray.put(json1);
        jsonArray.put(json2);
        jsonArray.put(json3);


        System.out.println(jsonArray.toString());

        List<StkCredentials> map = new ArrayList<>();


        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject cred = jsonArray.getJSONObject(i);
            System.out.println(cred.toString());
            if(cred.has("age")){
                StkCredentials stkCredentials=new StkCredentials();
                stkCredentials.setKey(cred.getString("name"));
                stkCredentials.setValue(cred.getString("age"));
                map.add(stkCredentials);

            }
            else{
                StkCredentials stkCredentials=new StkCredentials();
                stkCredentials.setKey(cred.getString("name"));
                stkCredentials.setValue("N/A");
                map.add(stkCredentials);
            }

        }
        for (StkCredentials stk:map){

            System.out.println(stk.getKey()+","+stk.getValue());


        }

    }
    @PostMapping("createTransaction")
    public ResponseEntity<ResponseBean> createTransaction(/*@RequestBody MpesaCall mpesaCall */) throws IOException {

//      String ammount=mpesaCall.getAmmount();
       JSONObject jsonObject = new JSONObject();
        jsonObject.put("ShortCode","600000");
        jsonObject.put("CommandID","CustomerPayBillOnline");
        jsonObject.put("Amount","900");
        jsonObject.put("Msisdn","254708374149");
        jsonObject.put("BillRefNumber","account");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken());
        HttpEntity<String> request =
                new HttpEntity<>(jsonObject.toString(),headers);

        String url="https://sandbox.safaricom.co.ke/mpesa/c2b/v1/simulate";


        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
          ResponseBean responseBean=new ResponseBean();
          responseBean.setMessage("successful");

        return ResponseEntity.ok(responseBean);
    }

    /*public String getLipaPassword(){

        Date date=new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        DateFormat dateFormat = new SimpleDateFormat("YmdHms");
        d=dateFormat.format(ts);
        System.out.println("First Timestamp :"+d);
        String passKey="bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919";
        String business="174379";
        String enc=business+passKey+d;
        return Base64.getEncoder().encodeToString(enc.getBytes());
    }

     */

    @GetMapping("/generateStkPush")
    public String generateStkPush(){
       // String c = new SimpleDateFormat("").format(new Timestamp(System.currentTimeMillis()));
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss", Locale.ENGLISH);
        String c = localDateTime.format(formatter);
        long pic=254759633686L;
        JSONObject json=new JSONObject();
        System.out.println("First Timestamp :"+c);
        String passKey="bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919";
        String business="174379";
        String enc=business+passKey+c;
        String encoded=Base64.getEncoder().encodeToString(enc.getBytes());
          System.out.println("Second Timestamp :"+c);
        json.put("BusinessShortCode","174379");
        json.put("Password",encoded);
        json.put("Timestamp",c);
        json.put("TransactionType","CustomerPayBillOnline");
        json.put("Amount","1");
        json.put("PartyA", pic);
        json.put("PartyB","174379");
        json.put("PhoneNumber",pic);
        json.put("CallBackURL","https://e1b9a7db5a7b.ngrok.io/validateUrl");
        json.put("AccountReference","Gabriel Kamau");
        json.put("TransactionDesc","Testing stk push on sandbox");
        /*

        'BusinessShortCode' => 174379,
                'Password' => $this->lipaNaMpesaPassword(),
                'Timestamp' => Carbon::rawParse('now')->format('YmdHms'),
                'TransactionType' => 'CustomerPayBillOnline',
                'Amount' => 5,
                'PartyA' => 254728858889, // replace this with your phone number
                'PartyB' => 174379,
                'PhoneNumber' => 254728858889, // replace this with your phone number
                'CallBackURL' => 'https://blog.hlab.tech/',
                'AccountReference' => "H-lab tutorial",
                'TransactionDesc' => "Testing stk push on sandbox"

         */


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authStkPush());
        HttpEntity<String> request =
                new HttpEntity<>(json.toString(),headers);

        String url="https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";


        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        return response.getBody();
    }

    @GetMapping("/generateClientStkPush")
    public String generateClientStkPush(@RequestBody MpesaCall mpesaCall){

        Long phone=Long.parseLong(mpesaCall.getPhone());
        String ammt=mpesaCall.getAmmount();
       // long pic=254725954981L;
        JSONObject json=new JSONObject();

        //long time = date.getTime();
        //Timestamp ts = new Timestamp(time);
        DateFormat dateFormat = new SimpleDateFormat("YmdHms");
        String c=dateFormat.format(new Date());
        System.out.println("First Timestamp :"+c);
        String passKey="bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919";
        String business="174379";
        String enc=business+passKey+c;
        String encoded=Base64.getEncoder().encodeToString(enc.getBytes());
        System.out.println("Second Timestamp :"+c);
        json.put("BusinessShortCode","174379");
        json.put("Password",encoded);
        json.put("Timestamp",c);
        json.put("TransactionType","CustomerPayBillOnline");
        json.put("Amount","1");
        json.put("PartyA", phone);
        json.put("PartyB","174379");
        json.put("PhoneNumber",phone);
        json.put("CallBackURL","https://5723d23da296.ngrok.io/validateUrl");
        json.put("AccountReference","Rensoft Solutions Limited");
        json.put("TransactionDesc","Testing stk push on sandbox");
        /*

        'BusinessShortCode' => 174379,
                'Password' => $this->lipaNaMpesaPassword(),
                'Timestamp' => Carbon::rawParse('now')->format('YmdHms'),
                'TransactionType' => 'CustomerPayBillOnline',
                'Amount' => 5,
                'PartyA' => 254728858889, // replace this with your phone number
                'PartyB' => 174379,
                'PhoneNumber' => 254728858889, // replace this with your phone number
                'CallBackURL' => 'https://blog.hlab.tech/',
                'AccountReference' => "H-lab tutorial",
                'TransactionDesc' => "Testing stk push on sandbox"

         */


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authStkPush());
        HttpEntity<String> request =
                new HttpEntity<>(json.toString(),headers);

        String url="https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";


        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        return response.getBody();
    }


}
